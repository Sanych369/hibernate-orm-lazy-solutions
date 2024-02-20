package test.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
// uncomment for test solution2
//@NamedEntityGraphs({
//        @NamedEntityGraph(name = "parent-with-children",
//                attributeNodes = {
//                        @NamedAttributeNode("childrenEntitySet")
//                })})
public class ParentEntity {

    @Id
    private Long parentId;

    @OneToMany(mappedBy = "parentEntity", cascade = CascadeType.ALL) // каскад для одного сейва связанных в логах можно увидеть 2 инсерта в разные таблицы
    @ToString.Exclude // исключаем OOM дефолтной реализации для oneToMany
    Set<ChildrenEntity> childrenEntitySet = new HashSet<>();

}
