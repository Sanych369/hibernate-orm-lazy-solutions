package test.project.service;

//import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph; // uncomment for test solution2
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.project.entity.ChildrenEntity;
import test.project.entity.ParentEntity;
import test.project.repository.ChildrenRepository;
import test.project.repository.ParentRepository;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final ChildrenRepository childrenRepository;
    private final ParentRepository parentRepository;
    private final EntityManager entityManager;

    private static final Long PARENT_ID = 1L;

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public void prepareDb() {
        System.out.println("<--DO PREPARE DB-->");
        parentRepository.deleteAll();
        childrenRepository.deleteAll();
        entityManager.flush();

        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setParentId(PARENT_ID);

        ChildrenEntity childrenEntity1 = new ChildrenEntity();
        childrenEntity1.setId(2L);

        childrenEntity1.setParentEntity(parentEntity);

        Set<ChildrenEntity> childrenEntitySet = new HashSet<>();
        childrenEntitySet.add(childrenEntity1);


        parentEntity.setChildrenEntitySet(childrenEntitySet);
        parentRepository.saveAndFlush(parentEntity); // выполняется вызов только 1 save, но сохраняются 2 объекта см. каскады у парент
        System.out.println("<--AFTER SAVING-->");
    }

    /**
     * Получаем родителя + чайлда
     * @return ParentEntity
     */
    public ParentEntity startParentWithChild() {
        return parentRepository
                .getParentEntityByParentId(PARENT_ID); //solution4


//                .fetchParentEntityAndChild(PARENT_ID); //uncomment for test solution1
//                .findById(PARENT_ID, NamedEntityGraph.fetching("parent-with-children")).orElse(null); //uncomment for test solution2
//                .fetchParentEntityAndChild(PARENT_ID); //uncomment for test solution3

    }
}
