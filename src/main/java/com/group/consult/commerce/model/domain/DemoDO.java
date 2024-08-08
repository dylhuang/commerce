package com.group.consult.commerce.model.domain;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Demo DO
 *
 * @author Huang, Dylan Bo
 * @since 2024/08/07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DemoDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4626411685855753958L;

    private String domainId;

    private String domainName;
}