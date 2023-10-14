package com.pathfinderapps.buildlineapi.service;

import com.pathfinderapps.buildlineapi.model.*;
import com.pathfinderapps.buildlineapi.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BasicService {

    private final CustomerRepo customerRepo;
    private final ItemLineRepo itemLineRepo;
    private final ItemRepo itemRepo;
    private final ItemStatusRepo itemStatusRepo;
    private final LineRepo lineRepo;
    private final PurchaseOrderRepo purchaseOrderRepo;
    private final StationRepo stationRepo;
    private final StationSectionRepo stationSectionRepo;

    Customer airstreamCustomer;
    StationSection queueSection;
    StationSection inProgressSection;
    StationSection completedSection;

    ItemStatus notStartedStatus;
    ItemStatus pushedBackStatus;
    ItemStatus inProgressStatus;
    ItemStatus blockedStatus;
    ItemStatus completedStatus;

    ItemLine flyingCloudItemLine;
    ItemLine atlasItemLine;
    ItemLine basecampItemLine;

    PurchaseOrder flyingCloudWindowCoversPO;
    PurchaseOrder atlasLoungesPO;
    PurchaseOrder basecampShowersPO;

    Item atlasLoungesItem001;
    Item atlasLoungesItem002;
    Item atlasLoungesItem003;
    Item atlasLoungesItem004;
    Item atlasLoungesItem005;
    Item atlasLoungesItem006;
    Item atlasLoungesItem007;
    Item atlasLoungesItem008;
    Item atlasLoungesItem009;
    Item atlasLoungesItem010;

    Item basecampShowersItem001;
    Item basecampShowersItem002;
    Item basecampShowersItem003;
    Item basecampShowersItem004;
    Item basecampShowersItem005;
    Item basecampShowersItem006;
    Item basecampShowersItem007;
    Item basecampShowersItem008;
    Item basecampShowersItem009;
    Item basecampShowersItem010;

    Station cutStation;
    Station sewStation;
    Station pipingStation;
    Station fitStation;
    Station qaStation;
    Station injectionStation;
    Station curingStation;
    Station otherQAStation;

    Line commerceLaneLine;
    Line kreinStreetLine;
    public List<Line> setupData(){

        //CUSTOMER CREATION
        createCustomers();
        //STATION CREATION
        createStationSection();
        //ITEM STATUS CREATION
        createItemStatuses();
        //ITEM LINE CREATION
        createItemLines();
        //PO CREATION
        createPurchaseOrders();
        //ITEM CREATION
        createItems();
        //STATION CREATION

        kreinStreetLine = new Line();
//        kreinStreetLine.setLineId(2L);
        kreinStreetLine.setNumberOfSteps(3);
        kreinStreetLine.setLineName("Krein Street Main Line");
        kreinStreetLine.setStationIds(new ArrayList<>());

        commerceLaneLine = new Line();
//        commerceLaneLine.setLineId(1L);
        commerceLaneLine.setNumberOfSteps(5);
        commerceLaneLine.setLineName("Commerce Lane Main Line");
        commerceLaneLine.setStationIds(new ArrayList<>());
        createStations();
        kreinStreetLine.getStationIds().add(injectionStation.getStationId());
        kreinStreetLine.getStationIds().add(curingStation.getStationId());
        kreinStreetLine.getStationIds().add(otherQAStation.getStationId());
        commerceLaneLine.getStationIds().add(cutStation.getStationId());
        commerceLaneLine.getStationIds().add(sewStation.getStationId());
        commerceLaneLine.getStationIds().add(pipingStation.getStationId());
        commerceLaneLine.getStationIds().add(fitStation.getStationId());
        commerceLaneLine.getStationIds().add(qaStation.getStationId());

        List<Line> lines = new ArrayList<>();

        lineRepo.save(commerceLaneLine);
        lineRepo.save(kreinStreetLine);

        lines.add(commerceLaneLine);
        lines.add(kreinStreetLine);
        log.info("lines being added... {}", lines);

        return lines;
    }

    private void createCustomers(){
        airstreamCustomer = new Customer();
        airstreamCustomer.setAddress("420 W Pike St, Jackson Center, OH 45334");
//        airstreamCustomer.setCustomerId(1L);
        airstreamCustomer.setName("Airstream");
        airstreamCustomer.setPhoneNumber("(937)596-6111");
        customerRepo.save(airstreamCustomer);
    }
    private void createItemStatuses(){
        notStartedStatus = new ItemStatus();
//        notStartedStatus.setItemStatusId(1L);
        notStartedStatus.setStatus("not_started");
        itemStatusRepo.save(notStartedStatus);

        pushedBackStatus = new ItemStatus();
//        pushedBackStatus.setItemStatusId(2L);
        pushedBackStatus.setStatus("pushed_back");
        itemStatusRepo.save(pushedBackStatus);

        inProgressStatus = new ItemStatus();
//        inProgressStatus.setItemStatusId(3L);
        inProgressStatus.setStatus("in_progress");
        itemStatusRepo.save(inProgressStatus);

        blockedStatus = new ItemStatus();
//        blockedStatus.setItemStatusId(4L);
        blockedStatus.setStatus("blocked");
        itemStatusRepo.save(blockedStatus);

        completedStatus = new ItemStatus();
//        completedStatus.setItemStatusId(5L);
        completedStatus.setStatus("completed");
        itemStatusRepo.save(completedStatus);
    }
    private void createStationSection(){
        queueSection = new StationSection();
        queueSection.setDescription("QUEUE");
//        queueSection.setStationSectionId(1L);
        stationSectionRepo.save(queueSection);

        inProgressSection = new StationSection();
        inProgressSection.setDescription("IN_PROGRESS");
//        inProgressSection.setStationSectionId(2L);
        stationSectionRepo.save(inProgressSection);

        completedSection = new StationSection();
        completedSection.setDescription("COMPLETED");
//        completedSection.setStationSectionId(3L);
        stationSectionRepo.save(completedSection);
    }
    private void createItemLines(){
        flyingCloudItemLine = new ItemLine();
//        flyingCloudItemLine.setItemLineId(1L);
        flyingCloudItemLine.setCustomer(airstreamCustomer);
        flyingCloudItemLine.setDescription("Flying Cloud");
        itemLineRepo.save(flyingCloudItemLine);

        atlasItemLine = new ItemLine();
//        atlasItemLine.setItemLineId(2L);
        atlasItemLine.setCustomer(airstreamCustomer);
        atlasItemLine.setDescription("Atlas");
        itemLineRepo.save(atlasItemLine);

        basecampItemLine = new ItemLine();
//        basecampItemLine.setItemLineId(3L);
        basecampItemLine.setCustomer(airstreamCustomer);
        basecampItemLine.setDescription("Basecamp");
        itemLineRepo.save(basecampItemLine);
    }
    private void createPurchaseOrders(){

        flyingCloudWindowCoversPO = new PurchaseOrder();
//        flyingCloudWindowCoversPO.setPurchaseOrderId(1L);
        flyingCloudWindowCoversPO.setDescription("Flying cloud Window coverings");
        flyingCloudWindowCoversPO.setQuantity(100);
        flyingCloudWindowCoversPO.setPrice(5000.00);
        flyingCloudWindowCoversPO.setReceivedDate(new Date(2023, 10, 1));
        flyingCloudWindowCoversPO.setDueDate(new Date(2023, 10, 30));
        flyingCloudWindowCoversPO.setCompletedDate(null);
        flyingCloudWindowCoversPO.setCustomer(airstreamCustomer);
        purchaseOrderRepo.save(flyingCloudWindowCoversPO);

        atlasLoungesPO = new PurchaseOrder();
//        atlasLoungesPO.setPurchaseOrderId(2L);
        atlasLoungesPO.setDescription("Atlas Lounges");
        atlasLoungesPO.setQuantity(10);
        atlasLoungesPO.setPrice(10000.00);
        atlasLoungesPO.setReceivedDate(new Date(2023, 10, 1));
        atlasLoungesPO.setDueDate(new Date(2023, 10, 30));
        atlasLoungesPO.setCompletedDate(null);
        atlasLoungesPO.setCustomer(airstreamCustomer);
        purchaseOrderRepo.save(atlasLoungesPO);

        basecampShowersPO = new PurchaseOrder();
//        basecampShowersPO.setPurchaseOrderId(3L);
        basecampShowersPO.setDescription("Basecamp Showers");
        basecampShowersPO.setQuantity(10);
        basecampShowersPO.setPrice(20000.00);
        basecampShowersPO.setReceivedDate(new Date(2023, 10, 1));
        basecampShowersPO.setDueDate(new Date(2023, 10, 30));
        basecampShowersPO.setCompletedDate(null);
        basecampShowersPO.setCustomer(airstreamCustomer);
        purchaseOrderRepo.save(basecampShowersPO);
    }
    private void createItems(){
        atlasLoungesItem001 = new Item();
//        atlasLoungesItem001.setItemId(1L);
        atlasLoungesItem001.setName("Atlas Lounge 001");
        atlasLoungesItem001.setColor("Beige");
        atlasLoungesItem001.setPartQuantity(1);
        atlasLoungesItem001.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem001.setWarningInSeconds(10L);
        atlasLoungesItem001.setErrorInSeconds(15L);
        atlasLoungesItem001.setTimeEnteredArea(new Date());
        atlasLoungesItem001.setItemLine(atlasItemLine);
        atlasLoungesItem001.setItemStatus(completedStatus);
        atlasLoungesItem001.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem001.setStationSection(completedSection);
        itemRepo.save(atlasLoungesItem001);

        atlasLoungesItem002 = new Item();
//        atlasLoungesItem002.setItemId(2L);
        atlasLoungesItem002.setName("Atlas Lounge 002");
        atlasLoungesItem002.setColor("Beige");
        atlasLoungesItem002.setPartQuantity(1);
        atlasLoungesItem002.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem002.setWarningInSeconds(5L);
        atlasLoungesItem002.setErrorInSeconds(10L);
        atlasLoungesItem002.setTimeEnteredArea(new Date());
        atlasLoungesItem002.setItemLine(atlasItemLine);
        atlasLoungesItem002.setItemStatus(blockedStatus);
        atlasLoungesItem002.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem002.setStationSection(inProgressSection);
        itemRepo.save(atlasLoungesItem002);

        atlasLoungesItem003 = new Item();
//        atlasLoungesItem003.setItemId(3L);
        atlasLoungesItem003.setName("Atlas Lounge 003");
        atlasLoungesItem003.setColor("Beige");
        atlasLoungesItem003.setPartQuantity(1);
        atlasLoungesItem003.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem003.setWarningInSeconds(20L);
        atlasLoungesItem003.setErrorInSeconds(45L);
        atlasLoungesItem003.setTimeEnteredArea(new Date());
        atlasLoungesItem003.setItemLine(atlasItemLine);
        atlasLoungesItem003.setItemStatus(inProgressStatus);
        atlasLoungesItem003.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem003.setStationSection(inProgressSection);
        itemRepo.save(atlasLoungesItem003);

        atlasLoungesItem004 = new Item();
//        atlasLoungesItem004.setItemId(4L);
        atlasLoungesItem004.setName("Atlas Lounge 004");
        atlasLoungesItem004.setColor("Beige");
        atlasLoungesItem004.setPartQuantity(1);
        atlasLoungesItem004.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem004.setWarningInSeconds(20L);
        atlasLoungesItem004.setErrorInSeconds(45L);
        atlasLoungesItem004.setTimeEnteredArea(new Date());
        atlasLoungesItem004.setItemLine(atlasItemLine);
        atlasLoungesItem004.setItemStatus(completedStatus);
        atlasLoungesItem004.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem004.setStationSection(completedSection);
        itemRepo.save(atlasLoungesItem004);

        atlasLoungesItem005 = new Item();
//        atlasLoungesItem005.setItemId(5L);
        atlasLoungesItem005.setName("Atlas Lounge 005");
        atlasLoungesItem005.setColor("Black");
        atlasLoungesItem005.setPartQuantity(1);
        atlasLoungesItem005.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem005.setWarningInSeconds(20L);
        atlasLoungesItem005.setErrorInSeconds(45L);
        atlasLoungesItem005.setTimeEnteredArea(new Date());
        atlasLoungesItem005.setItemLine(atlasItemLine);
        atlasLoungesItem005.setItemStatus(notStartedStatus);
        atlasLoungesItem005.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem005.setStationSection(queueSection);
        itemRepo.save(atlasLoungesItem005);

        atlasLoungesItem006 = new Item();
//        atlasLoungesItem006.setItemId(6L);
        atlasLoungesItem006.setName("Atlas Lounge 006");
        atlasLoungesItem006.setColor("Black");
        atlasLoungesItem006.setPartQuantity(1);
        atlasLoungesItem006.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem006.setWarningInSeconds(20L);
        atlasLoungesItem006.setErrorInSeconds(45L);
        atlasLoungesItem006.setTimeEnteredArea(new Date());
        atlasLoungesItem006.setItemLine(atlasItemLine);
        atlasLoungesItem006.setItemStatus(pushedBackStatus);
        atlasLoungesItem006.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem006.setStationSection(queueSection);
        itemRepo.save(atlasLoungesItem006);

        atlasLoungesItem007 = new Item();
//        atlasLoungesItem007.setItemId(7L);
        atlasLoungesItem007.setName("Atlas Lounge 007");
        atlasLoungesItem007.setColor("Black");
        atlasLoungesItem007.setPartQuantity(1);
        atlasLoungesItem007.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem007.setWarningInSeconds(20L);
        atlasLoungesItem007.setErrorInSeconds(45L);
        atlasLoungesItem007.setTimeEnteredArea(new Date());
        atlasLoungesItem007.setItemLine(atlasItemLine);
        atlasLoungesItem007.setItemStatus(inProgressStatus);
        atlasLoungesItem007.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem007.setStationSection(inProgressSection);
        itemRepo.save(atlasLoungesItem007);

        atlasLoungesItem008 = new Item();
//        atlasLoungesItem008.setItemId(8L);
        atlasLoungesItem008.setName("Atlas Lounge 008");
        atlasLoungesItem008.setColor("Black");
        atlasLoungesItem008.setPartQuantity(1);
        atlasLoungesItem008.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem008.setWarningInSeconds(20L);
        atlasLoungesItem008.setErrorInSeconds(45L);
        atlasLoungesItem008.setTimeEnteredArea(new Date());
        atlasLoungesItem008.setItemLine(atlasItemLine);
        atlasLoungesItem008.setItemStatus(notStartedStatus);
        atlasLoungesItem008.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem008.setStationSection(queueSection);
        itemRepo.save(atlasLoungesItem008);

        atlasLoungesItem009 = new Item();
//        atlasLoungesItem009.setItemId(9L);
        atlasLoungesItem009.setName("Atlas Lounge 009");
        atlasLoungesItem009.setColor("Black");
        atlasLoungesItem009.setPartQuantity(1);
        atlasLoungesItem009.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem009.setWarningInSeconds(20L);
        atlasLoungesItem009.setErrorInSeconds(45L);
        atlasLoungesItem009.setTimeEnteredArea(new Date());
        atlasLoungesItem009.setItemLine(atlasItemLine);
        atlasLoungesItem009.setItemStatus(notStartedStatus);
        atlasLoungesItem009.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem009.setStationSection(queueSection);
        itemRepo.save(atlasLoungesItem009);

        atlasLoungesItem010 = new Item();
//        atlasLoungesItem010.setItemId(10L);
        atlasLoungesItem010.setName("Atlas Lounge 010");
        atlasLoungesItem010.setColor("Black");
        atlasLoungesItem010.setPartQuantity(1);
        atlasLoungesItem010.setItemDescription("Bench recliner for atlas lounge");
        atlasLoungesItem010.setWarningInSeconds(20L);
        atlasLoungesItem010.setErrorInSeconds(45L);
        atlasLoungesItem010.setTimeEnteredArea(new Date());
        atlasLoungesItem010.setItemLine(atlasItemLine);
        atlasLoungesItem010.setItemStatus(completedStatus);
        atlasLoungesItem010.setPurchaseOrder(atlasLoungesPO);
        atlasLoungesItem010.setStationSection(completedSection);
        itemRepo.save(atlasLoungesItem010);

        basecampShowersItem001 = new Item();
//        basecampShowersItem001.setItemId(1L);
        basecampShowersItem001.setName("Basecamp Shower 001");
        basecampShowersItem001.setColor("White");
        basecampShowersItem001.setPartQuantity(1);
        basecampShowersItem001.setItemDescription("Shower for Basecamp");
        basecampShowersItem001.setWarningInSeconds(10L);
        basecampShowersItem001.setErrorInSeconds(15L);
        basecampShowersItem001.setTimeEnteredArea(new Date());
        basecampShowersItem001.setItemLine(basecampItemLine);
        basecampShowersItem001.setItemStatus(pushedBackStatus);
        basecampShowersItem001.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem001.setStationSection(queueSection);
        itemRepo.save(basecampShowersItem001);

        basecampShowersItem002 = new Item();
//        basecampShowersItem002.setItemId(2L);
        basecampShowersItem002.setName("Basecamp Shower 002");
        basecampShowersItem002.setColor("White");
        basecampShowersItem002.setPartQuantity(1);
        basecampShowersItem002.setItemDescription("Shower for Basecamp");
        basecampShowersItem002.setWarningInSeconds(10L);
        basecampShowersItem002.setErrorInSeconds(15L);
        basecampShowersItem002.setTimeEnteredArea(new Date());
        basecampShowersItem002.setItemLine(basecampItemLine);
        basecampShowersItem002.setItemStatus(inProgressStatus);
        basecampShowersItem002.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem002.setStationSection(inProgressSection);
        itemRepo.save(basecampShowersItem002);

        basecampShowersItem003 = new Item();
//        basecampShowersItem003.setItemId(3L);
        basecampShowersItem003.setName("Basecamp Shower 003");
        basecampShowersItem003.setColor("White");
        basecampShowersItem003.setPartQuantity(1);
        basecampShowersItem003.setItemDescription("Shower for Basecamp");
        basecampShowersItem003.setWarningInSeconds(10L);
        basecampShowersItem003.setErrorInSeconds(15L);
        basecampShowersItem003.setTimeEnteredArea(new Date());
        basecampShowersItem003.setItemLine(basecampItemLine);
        basecampShowersItem003.setItemStatus(completedStatus);
        basecampShowersItem003.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem003.setStationSection(completedSection);
        itemRepo.save(basecampShowersItem003);

        basecampShowersItem004 = new Item();
//        basecampShowersItem004.setItemId(4L);
        basecampShowersItem004.setName("Basecamp Shower 004");
        basecampShowersItem004.setColor("White");
        basecampShowersItem004.setPartQuantity(1);
        basecampShowersItem004.setItemDescription("Shower for Basecamp");
        basecampShowersItem004.setWarningInSeconds(10L);
        basecampShowersItem004.setErrorInSeconds(15L);
        basecampShowersItem004.setTimeEnteredArea(new Date());
        basecampShowersItem004.setItemLine(basecampItemLine);
        basecampShowersItem004.setItemStatus(notStartedStatus);
        basecampShowersItem004.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem004.setStationSection(queueSection);
        itemRepo.save(basecampShowersItem004);

        basecampShowersItem005 = new Item();
//        basecampShowersItem005.setItemId(5L);
        basecampShowersItem005.setName("Basecamp Shower 005");
        basecampShowersItem005.setColor("White");
        basecampShowersItem005.setPartQuantity(1);
        basecampShowersItem005.setItemDescription("Shower for Basecamp");
        basecampShowersItem005.setWarningInSeconds(10L);
        basecampShowersItem005.setErrorInSeconds(15L);
        basecampShowersItem005.setTimeEnteredArea(new Date());
        basecampShowersItem005.setItemLine(basecampItemLine);
        basecampShowersItem005.setItemStatus(inProgressStatus);
        basecampShowersItem005.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem005.setStationSection(inProgressSection);
        itemRepo.save(basecampShowersItem005);

        basecampShowersItem006 = new Item();
//        basecampShowersItem006.setItemId(6L);
        basecampShowersItem006.setName("Basecamp Shower 006");
        basecampShowersItem006.setColor("White");
        basecampShowersItem006.setPartQuantity(1);
        basecampShowersItem006.setItemDescription("Shower for Basecamp");
        basecampShowersItem006.setWarningInSeconds(10L);
        basecampShowersItem006.setErrorInSeconds(15L);
        basecampShowersItem006.setTimeEnteredArea(new Date());
        basecampShowersItem006.setItemLine(basecampItemLine);
        basecampShowersItem006.setItemStatus(completedStatus);
        basecampShowersItem006.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem006.setStationSection(completedSection);
        itemRepo.save(basecampShowersItem006);

        basecampShowersItem007 = new Item();
//        basecampShowersItem007.setItemId(7L);
        basecampShowersItem007.setName("Basecamp Shower 007");
        basecampShowersItem007.setColor("White");
        basecampShowersItem007.setPartQuantity(1);
        basecampShowersItem007.setItemDescription("Shower for Basecamp");
        basecampShowersItem007.setWarningInSeconds(10L);
        basecampShowersItem007.setErrorInSeconds(15L);
        basecampShowersItem007.setTimeEnteredArea(new Date());
        basecampShowersItem007.setItemLine(basecampItemLine);
        basecampShowersItem007.setItemStatus(notStartedStatus);
        basecampShowersItem007.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem007.setStationSection(queueSection);
        itemRepo.save(basecampShowersItem007);

        basecampShowersItem008 = new Item();
//        basecampShowersItem008.setItemId(8L);
        basecampShowersItem008.setName("Basecamp Shower 008");
        basecampShowersItem008.setColor("White");
        basecampShowersItem008.setPartQuantity(1);
        basecampShowersItem008.setItemDescription("Shower for Basecamp");
        basecampShowersItem008.setWarningInSeconds(10L);
        basecampShowersItem008.setErrorInSeconds(15L);
        basecampShowersItem008.setTimeEnteredArea(new Date());
        basecampShowersItem008.setItemLine(basecampItemLine);
        basecampShowersItem008.setItemStatus(inProgressStatus);
        basecampShowersItem008.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem008.setStationSection(inProgressSection);
        itemRepo.save(basecampShowersItem008);

        basecampShowersItem009 = new Item();
//        basecampShowersItem009.setItemId(9L);
        basecampShowersItem009.setName("Basecamp Shower 009");
        basecampShowersItem009.setColor("White");
        basecampShowersItem009.setPartQuantity(1);
        basecampShowersItem009.setItemDescription("Shower for Basecamp");
        basecampShowersItem009.setWarningInSeconds(10L);
        basecampShowersItem009.setErrorInSeconds(15L);
        basecampShowersItem009.setTimeEnteredArea(new Date());
        basecampShowersItem009.setItemLine(basecampItemLine);
        basecampShowersItem009.setItemStatus(completedStatus);
        basecampShowersItem009.setPurchaseOrder(basecampShowersPO);
        basecampShowersItem009.setStationSection(completedSection);
        itemRepo.save(basecampShowersItem009);
    }

    private void createStations(){

        cutStation = new Station();
//        cutStation.setStationId(1L);
        cutStation.setCurrentItems(new ArrayList<>());
        cutStation.setBacklogItems(new ArrayList<>());
        cutStation.setCompletedItems(new ArrayList<>());
        cutStation.getCurrentItems().add(atlasLoungesItem007);
        cutStation.getBacklogItems().add(atlasLoungesItem005);
        cutStation.getCompletedItems().add(atlasLoungesItem004);
        cutStation.setName("cut");
        cutStation.setWarnings(0);
        cutStation.setErrors(0);
        cutStation.setStationWorker("Person 1");
        cutStation.setLine(commerceLaneLine);
        cutStation = stationRepo.save(cutStation);

        sewStation = new Station();
//        sewStation.setStationId(2L);
        sewStation.setCurrentItems(new ArrayList<>());
        sewStation.setBacklogItems(new ArrayList<>());
        sewStation.setCompletedItems(new ArrayList<>());
        sewStation.getCurrentItems().add(atlasLoungesItem002);
        sewStation.getBacklogItems().add(atlasLoungesItem006);
        sewStation.getCompletedItems().add(atlasLoungesItem010);
        sewStation.setName("sew");
        sewStation.setWarnings(0);
        sewStation.setErrors(0);
        sewStation.setStationWorker("Person 2");
        sewStation.setLine(commerceLaneLine);
        sewStation = stationRepo.save(sewStation);

        pipingStation = new Station();
//        pipingStation.setStationId(3L);
        pipingStation.setCurrentItems(new ArrayList<>());
        pipingStation.setBacklogItems(new ArrayList<>());
        pipingStation.setCompletedItems(new ArrayList<>());
        pipingStation.getCurrentItems().add(atlasLoungesItem003);
        pipingStation.getBacklogItems().add(atlasLoungesItem006);
        pipingStation.getCompletedItems().add(null);
        pipingStation.setName("piping");
        pipingStation.setWarnings(0);
        pipingStation.setErrors(0);
        pipingStation.setStationWorker("Person 3");
        pipingStation.setLine(commerceLaneLine);
        pipingStation = stationRepo.save(pipingStation);

        fitStation = new Station();
//        fitStation.setStationId(4L);
        fitStation.setCurrentItems(new ArrayList<>());
        fitStation.setBacklogItems(new ArrayList<>());
        fitStation.setCompletedItems(new ArrayList<>());
        fitStation.getCurrentItems().add(null);
        fitStation.getBacklogItems().add(atlasLoungesItem008);
        fitStation.getCompletedItems().add(null);
        fitStation.setName("fit");
        fitStation.setWarnings(0);
        fitStation.setErrors(0);
        fitStation.setStationWorker("Person 4");
        fitStation.setLine(commerceLaneLine);
        fitStation = stationRepo.save(fitStation);

        qaStation = new Station();
//        qaStation.setStationId(5L);
        qaStation.setCurrentItems(new ArrayList<>());
        qaStation.setBacklogItems(new ArrayList<>());
        qaStation.setCompletedItems(new ArrayList<>());
        qaStation.getCurrentItems().add(null);
        qaStation.getBacklogItems().add(atlasLoungesItem009);
        qaStation.getCompletedItems().add(atlasLoungesItem001);
        qaStation.setName("qa");
        qaStation.setWarnings(0);
        qaStation.setErrors(0);
        qaStation.setStationWorker("Person 5");
        qaStation.setLine(commerceLaneLine);
        qaStation = stationRepo.save(qaStation);

        injectionStation = new Station();
//        injectionStation.setStationId(6L);
        injectionStation.setCurrentItems(new ArrayList<>());
        injectionStation.setBacklogItems(new ArrayList<>());
        injectionStation.setCompletedItems(new ArrayList<>());
        injectionStation.getCurrentItems().add(basecampShowersItem002);
        injectionStation.getBacklogItems().add(basecampShowersItem001);
        injectionStation.getCompletedItems().add(basecampShowersItem003);
        injectionStation.setName("injection");
        injectionStation.setWarnings(0);
        injectionStation.setErrors(0);
        injectionStation.setStationWorker("Person 6");
        injectionStation.setLine(kreinStreetLine);
        injectionStation = stationRepo.save(injectionStation);

        curingStation = new Station();
//        curingStation.setStationId(7L);
        curingStation.setCurrentItems(new ArrayList<>());
        curingStation.setBacklogItems(new ArrayList<>());
        curingStation.setCompletedItems(new ArrayList<>());
        curingStation.getCurrentItems().add(basecampShowersItem005);
        curingStation.getBacklogItems().add(basecampShowersItem004);
        curingStation.getCompletedItems().add(basecampShowersItem006);
        curingStation.setName("curing");
        curingStation.setWarnings(0);
        curingStation.setErrors(0);
        curingStation.setStationWorker("Person 7");
        curingStation.setLine(kreinStreetLine);
        curingStation = stationRepo.save(curingStation);

        otherQAStation = new Station();
//        otherQAStation.setStationId(8L);
        otherQAStation.setCurrentItems(new ArrayList<>());
        otherQAStation.setBacklogItems(new ArrayList<>());
        otherQAStation.setCompletedItems(new ArrayList<>());
        otherQAStation.getCurrentItems().add(basecampShowersItem008);
        otherQAStation.getBacklogItems().add(basecampShowersItem007);
        otherQAStation.getCompletedItems().add(basecampShowersItem009);
        otherQAStation.setName("qa");
        otherQAStation.setWarnings(0);
        otherQAStation.setErrors(0);
        otherQAStation.setStationWorker("Person 8");
        otherQAStation.setLine(kreinStreetLine);
        otherQAStation = stationRepo.save(otherQAStation);

    }
}
