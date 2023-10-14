package com.pathfinderapps.buildlineapi.util;

import lombok.Data;

/**
 * This object contains all the Objects needed to have a properly formed
 * Item
 */
@Data
public class ObjectsToItemForm {
    Long itemId;
    Long itemLineId;
    Long itemStatusId;
    Long purchaseOrderId;
    Long stationSectionDescriptionId;
    Long stationId;
}
