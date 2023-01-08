package com.aimcodes.employeemanagementbe.pojos.requests;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateEmployeeRequest {

    private String firstName;
    private String lastName;
    private String email;
}
