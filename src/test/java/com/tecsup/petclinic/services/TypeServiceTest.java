package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.tecsup.petclinic.entities.Type;
import com.tecsup.petclinic.exceptions.TypeNotFoundException;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TypeServiceTest {
    @Autowired
    private TypeService typeService;

    /**
     * Buscar tipo por ID
     */
    @Test
    public void testFindTypeById() {

        Integer ID = 1;
        String NAME_EXPECTED = "cat";

        Type type = null;

        try {
            type = this.typeService.findById(ID);
        } catch (TypeNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("TYPE FOUND: " + type);

        assertNotNull(type);
        assertEquals(NAME_EXPECTED, type.getName());
    }

    /**
     * Buscar tipo por nombre
     */
    @Test
    public void testFindTypeByName() {

        String FIND_NAME = "dog";
        int SIZE_EXPECTED = 1;

        List<Type> types = this.typeService.findByName(FIND_NAME);

        assertEquals(SIZE_EXPECTED, types.size());
        assertEquals(FIND_NAME, types.get(0).getName());
    }
}

