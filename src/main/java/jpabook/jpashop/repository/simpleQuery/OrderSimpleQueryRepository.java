package jpabook.jpashop.repository.simpleQuery;

import jpabook.jpashop.repository.simpleQuery.OrderSimpleQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.simpleQuery.OrderSimpleQueryDto(o.id, m.name, o.oderDate, o.status, d.address) "+
                        " from Order o" +
                        " join o.member m" +
                        " join o.deliver d", OrderSimpleQueryDto.class)
                .getResultList();
    }
}
