package com.example.HAL.Explorer.crud.HAL.Explorer.repositories;

import com.example.HAL.Explorer.crud.HAL.Explorer.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages", collectionResourceDescription = @Description("questa è la descrizione dell' esercizio CRUD Hal-explorer(modificato)"))


public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
