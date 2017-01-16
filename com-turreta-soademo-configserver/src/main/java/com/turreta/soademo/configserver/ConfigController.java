package com.turreta.soademo.configserver;

import com.turreta.soademo.common.dto.AppConfigDTO;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SANG018 on 1/16/2017.
 */
@RestController
public class ConfigController {

    private List<AppConfigDTO> predefinedConfigList = new ArrayList<>();

    @PostConstruct
    public void postContruct() {

        AppConfigDTO dto1 = new AppConfigDTO();
        dto1.setApplicationName("app-1");
        dto1.setVersion("1.2.3");
        dto1.setIsEnabled(false);

        AppConfigDTO dto2 = new AppConfigDTO();
        dto2.setApplicationName("app-2");
        dto2.setVersion("1.2.3");
        dto2.setIsEnabled(true);


        predefinedConfigList.add(dto1);
        predefinedConfigList.add(dto2);
    }

    @RequestMapping(value = "/get-config-by-name", method = RequestMethod.POST)
    public AppConfigDTO findConfig(@RequestBody AppConfigDTO findDTO) {

        AppConfigDTO rtnDto = null;

        for(AppConfigDTO d: this.predefinedConfigList) {
            if(d.getApplicationName().equals(findDTO.getApplicationName())) {
                rtnDto = d;
                break;
            }
        }

        return rtnDto;
    }
}
