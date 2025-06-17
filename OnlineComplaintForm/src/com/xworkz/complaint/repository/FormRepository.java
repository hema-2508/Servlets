package com.xworkz.complaint.repository;


import com.xworkz.complaint.dto.DetailsDto;

public interface FormRepository {
    boolean persist(DetailsDto detailsDto);
}