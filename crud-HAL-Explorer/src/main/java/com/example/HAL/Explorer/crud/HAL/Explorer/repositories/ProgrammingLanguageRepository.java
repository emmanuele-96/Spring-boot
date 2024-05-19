package com.example.HAL.Explorer.crud.HAL.Explorer.repositories;

import com.example.HAL.Explorer.crud.HAL.Explorer.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@Description("repo-prog-languages")

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
