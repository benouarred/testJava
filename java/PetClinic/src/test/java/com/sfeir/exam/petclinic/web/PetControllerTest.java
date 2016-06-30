package com.sfeir.exam.petclinic.web;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.sfeir.exam.petclinic.dao.OwnerDao;
import com.sfeir.exam.petclinic.dao.PetDao;
import com.sfeir.exam.petclinic.domain.Pet;

/**
 * Created by davidhollick on 29/06/16.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class PetControllerTest {

    @Mock
    PetDao mockPetDao;
    @Mock
    OwnerDao mockOwnwerDao;
    @InjectMocks
    PetController controller;

    @Before
    public void init() {
        controller = new PetController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowPet() throws Exception {
        Pet expectedPet = new Pet();
        expectedPet.setId(-1L);
        expectedPet.setName("Dog :"+-1L);

        when(mockPetDao.findPet(-1L)).thenReturn(expectedPet);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/pets/"+-1L))
                .andExpect(view().name("pets/show"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attribute("pet", expectedPet));

        verify(mockPetDao).findPet(-1L);
    }
}
