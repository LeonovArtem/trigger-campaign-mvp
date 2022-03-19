package com.mostbet.triggerCampaign.integration.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class User  implements Serializable {
    private String id;
}
