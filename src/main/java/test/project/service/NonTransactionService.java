package test.project.service;

import org.springframework.stereotype.Service;
import test.project.entity.ParentEntity;

@Service
public class NonTransactionService {
    /**
     * Нетранзакционный метод для выведения в лог состояния объекта(не сущности в контексте)
     * @param parentEntity - объект
     */
    public void getChild(ParentEntity parentEntity) {
        System.out.println("CHILDREN SET SIZE = " + parentEntity.getChildrenEntitySet().size());
        System.out.println(parentEntity.getChildrenEntitySet());
    }
}
