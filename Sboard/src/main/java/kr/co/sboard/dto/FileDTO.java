package kr.co.sboard.dto;

import jakarta.persistence.*;
import kr.co.sboard.entity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
    private int fno;
    private int ano;
    private String ofile;
    private String sfile;
    private int download;
    private LocalDateTime rdate;

    public FileEntity toEntity(){
        return FileEntity.builder()
                .fno(fno)
                .ano(ano)
                .ofile(ofile)
                .sfile(sfile)
                .download(download)
                .rdate(rdate)
                .build();
    }
}
