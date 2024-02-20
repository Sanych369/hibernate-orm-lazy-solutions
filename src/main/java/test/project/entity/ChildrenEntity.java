package test.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
public class ChildrenEntity {

    @Id
    private Long id;

    @JoinColumn(name = "parentEntity_id")
    @ManyToOne(fetch = FetchType.LAZY)
    ParentEntity parentEntity;
}
