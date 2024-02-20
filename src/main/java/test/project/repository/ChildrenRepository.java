package test.project.repository;

import test.project.entity.ChildrenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<ChildrenEntity, Long> {
}
