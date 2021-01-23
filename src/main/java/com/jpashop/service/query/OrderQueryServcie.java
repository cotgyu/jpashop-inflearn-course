package com.jpashop.service.query;

import com.jpashop.api.OrderApiController;
import com.jpashop.domain.Order;
import com.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryServcie {

    private final OrderRepository orderRepository;

    public List<OrderApiController.OrderDto> orderV3(){
        List<Order> orders = orderRepository.findAllWithItem();

        List<OrderApiController.OrderDto> collect = orders.stream()
                .map(o -> new OrderApiController.OrderDto(o))
                .collect(toList());

        return collect;
    }
}
