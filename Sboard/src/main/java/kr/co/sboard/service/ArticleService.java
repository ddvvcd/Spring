package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByParentAndCate(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("no");
        //아래쪽과 같음
        //Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no");
        Page<ArticleEntity> result = articleRepository.findByParentAndCate(0, pageRequestDTO.getCate(), pageable);

        List<ArticleDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ArticleDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                              .pageRequestDTO(pageRequestDTO)
                                .dtoList(dtoList)
                                .total(totalElement)
                                .build();
    }

    public void save(ArticleDTO dto){

        // 글 등록
        ArticleEntity savedEntity = articleRepository.save(dto.toEntity());

        // 파일 업로드
        FileDTO fileDTO = fileUpload(dto);

        if(fileDTO != null){
            // 파일 등록
            fileDTO.setAno(savedEntity.getNo());
            fileRepository.save(fileDTO.toEntity());
        }
    }


    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {

        log.info("fileUpload...1");
        MultipartFile mf = dto.getFname();

        log.info("fileUpload...2 : " + mf);

        if(!mf.isEmpty()){
            // 파일 첨부 했을 경우
            String path = new File(filePath).getAbsolutePath();
            log.info("fileUpload...3 : " + path);

            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString()+ext;

            log.info("fileUpload...4 : " + oName);

            try {
                log.info("fileUpload...5");
                mf.transferTo(new File(path, sName));
                log.info("fileUpload...6");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            log.info("fileUpload...7");
            return FileDTO.builder().ofile(oName).sfile(sName).build();
        }
        log.info("fileUpload...8");
        return null;
    }

}
