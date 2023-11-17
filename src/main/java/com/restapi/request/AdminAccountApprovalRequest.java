package com.restapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminAccountApprovalRequest {
    private Long id;

    private boolean isBoolean;
}
