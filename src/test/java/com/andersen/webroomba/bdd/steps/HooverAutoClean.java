package com.andersen.webroomba.bdd.steps;

import java.util.List;
import java.util.stream.Collectors;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.model.Hoover;
import com.andersen.webroomba.model.implementation.RoomGrid;
import com.andersen.webroomba.service.DirtContainerService;
import com.andersen.webroomba.service.GridCreatorService;
import com.andersen.webroomba.service.HooverCreatorService;
import com.andersen.webroomba.service.RoomCleanerService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HooverAutoClean  {

    private final static List<int[]> dirtPatchesCoordinates =
            List.of(new int[]{ 0, 1 }, new int[]{ 1, 0 }, new int[]{ 1, 1 });

    private GridConfiguration configuration;
    private RoomGrid grid;
    private Hoover hoover;
    private GridCleaningResult result;

    private final GridCreatorService gridCreatorService;
    private final HooverCreatorService hooverCreator;
    private final RoomCleanerService roomCleanerService;
    private final DirtContainerService dirtContainerService;

    public HooverAutoClean(
            GridCreatorService gridCreatorService,
            HooverCreatorService hooverCreator,
            RoomCleanerService roomCleanerService,
            DirtContainerService dirtContainerService) {
        this.gridCreatorService = gridCreatorService;
        this.hooverCreator = hooverCreator;
        this.roomCleanerService = roomCleanerService;
        this.dirtContainerService = dirtContainerService;
    }

    @Given("I have a grid with {int} patches of dirt")
    public void iHaveAGridWithPatchesOfDirt(int patchesOfDirt) {
        configuration = new GridConfiguration();
        configuration.setRoomSize(new int[]{ 2, 2 });
        configuration.setCoords(new int[]{ 0, 0 });
        List<int[]> dirtPatchesForActualTestInvocation = dirtPatchesCoordinates.stream()
                .limit(patchesOfDirt)
                .collect(Collectors.toList());
        configuration.setPatches(dirtPatchesForActualTestInvocation);
        configuration.setInstructions("NESW");
        grid = gridCreatorService.createGrid(configuration);
    }

    @And("i have a hoover")
    public void iHaveAHoover() {
        hoover = hooverCreator.createHoover(grid, configuration);
    }

    @And("i run a hoover to clean the dirt")
    public void iRunAHooverToCleanTheDirt() {
        result = roomCleanerService.cleanRoom(hoover);
    }

    @When("a hoover finishes the cleanup having cleaned {int} patches of dirt")
    public void aHooverFinishesTheCleanupHavingCleanedPatchesOfDirt(int patchesOfDirt) {
        assertEquals(result.getPatches(), patchesOfDirt);
    }

    @Then("it's dirt container should be empty")
    public void itSDirtContainerShouldBeEmpty() {
        assertEquals(0, hoover.getCollectedDirtPatches());

    }

}
