package com.mostbet.triggerCampaign.repository.specification;

import com.mostbet.triggerCampaign.entity.Condition;
import com.mostbet.triggerCampaign.entity.dto.criteria.ConditionCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ConditionSpecification {
    public static Specification<Condition> conditionIdOrConditionTypeOrName(ConditionCriteria conditionCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (conditionCriteria.getId() != null) {
                Predicate idPredicate = criteriaBuilder.equal(root.get("id"), conditionCriteria.getId());
                predicates.add(idPredicate);
            }

            if (conditionCriteria.getConditionType() != null) {
                Predicate typePredicate = criteriaBuilder.equal(root.get("type"), conditionCriteria.getConditionType());
                predicates.add(typePredicate);
            }

            if (conditionCriteria.getName() != null) {
                Predicate typePredicate = criteriaBuilder.like(
                        root.get("name"), "%" + conditionCriteria.getName() + "%"
                );
                predicates.add(typePredicate);
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
