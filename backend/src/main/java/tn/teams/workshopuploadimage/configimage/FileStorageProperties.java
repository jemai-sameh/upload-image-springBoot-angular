package tn.teams.workshopuploadimage.configimage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Component
public class FileStorageProperties {
    private String uploadImgUsersDir;

   /* public String getUploadImgUsersDir() {
        return uploadImgUsersDir;
    }

    public void setUploadImgUsersDir(String uploadImgUsersDir) {
        this.uploadImgUsersDir = uploadImgUsersDir;
    }*/

}
