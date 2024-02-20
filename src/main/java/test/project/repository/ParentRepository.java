package test.project.repository;

//import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph; //uncomment for test solution2
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.project.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {

    //solution1 HQL
//    @Query("FROM ParentEntity p " +
//            "JOIN FETCH p.childrenEntitySet child where p.id = ?1")
//    ParentEntity fetchParentEntityAndChild(Long id);

    //solution2 GRAPH
//    Optional<ParentEntity> findById(Long id, EntityGraph entityGraph);

    //solution3 JPQL
//        @Query("Select p from ParentEntity p join fetch p.childrenEntitySet c where p.parentId = :id")
//        ParentEntity fetchParentEntityAndChild(@Param("id") Long id);

//    solution4 GRAPH
    @EntityGraph(attributePaths = {"childrenEntitySet"}, type = EntityGraph.EntityGraphType.LOAD)
    ParentEntity getParentEntityByParentId(Long id);
}
