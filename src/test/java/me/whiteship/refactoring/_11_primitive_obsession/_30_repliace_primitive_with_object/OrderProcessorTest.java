package me.whiteship.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProcessorTest {

    @Test
    void numberOfHighPriorityOrders() {
        OrderProcessor orderProcessor = new OrderProcessor();
        long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
                List.of(new Order(Priority.LOW),
                        new Order(Priority.NORMAL),
                        new Order(Priority.HIGH),
                        new Order(Priority.RUSH)));
        assertEquals(2, highPriorityOrders);
    }

    @Test
    void compareTest() {
        Priority higher = Priority.RUSH;
        Priority lower = Priority.LOW;
        assertEquals(true, higher.isImportantThan(lower));
        assertEquals(false, lower.isImportantThan(higher));
    }

}