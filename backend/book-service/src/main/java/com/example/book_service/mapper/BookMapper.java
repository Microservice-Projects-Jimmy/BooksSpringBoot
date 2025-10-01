package com.example.book_service.mapper;

import com.example.book_service.dto.business.response.BookResponseDTO;
import com.example.book_service.model.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDTO toDTO(BookEntity entity);
}
