package com.von.user.common.component.files;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageVo {
    private Long imageId;
    String name;
    Long lastModified;
    Long lastModifiedDate;
    String type;
    String webkitRelativePath;
    Long size;
}
