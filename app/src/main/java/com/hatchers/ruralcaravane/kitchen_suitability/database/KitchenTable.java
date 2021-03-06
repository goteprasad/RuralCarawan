package com.hatchers.ruralcaravane.kitchen_suitability.database;


import android.os.Parcel;
import android.os.Parcelable;

public class KitchenTable implements Parcelable{


    public static final String KITCHEN_TABLE="KitchenTable";

    public static final String KITCHEN_ID="kitchen_id",KITCHEN_UNIQUE_ID="unique_id",HOUSE_TYPE="house_type",
                               ROOF_TYPE="roof_type",KITCHEN_HEIGHT="kitchen_height",UPLOAD_STATUS="upload_status",
                               PLACE_IMAGE="place_image",LATITUDE="latitude",LONGITUDE="longitude",GEO_ADDRESS="geo_address",
                               UPLOAD_DATE="upload_date",COST_OF_CHULLHA="cost_of_chullha",CUSTOMER_ID = "customer_id",
                               CUSTOMER_NAME="customer_name",STEP1_IMAGE="step1_image",STEP2_IMAGE="step2_image",
                               ADDED_DATE="added_date",USER_UNIQUE_ID="user_unique_id",ADDED_BY_ID="added_by_id",
                               UPDATE_DATE="update_date";

    public static final String CREATE_KITCHEN_TABLE="CREATE TABLE " + KITCHEN_TABLE +
            "("+KITCHEN_ID+" int PRIMARY KEY ,"+HOUSE_TYPE+" TEXT,"+ROOF_TYPE+" TEXT,"
            +KITCHEN_HEIGHT+" TEXT, "+UPLOAD_STATUS+" TEXT, "+CUSTOMER_ID+" TEXT, "+CUSTOMER_NAME+" TEXT, "
            +PLACE_IMAGE+" TEXT, "+KITCHEN_UNIQUE_ID+" TEXT, "+LATITUDE+" TEXT, "+LONGITUDE+" TEXT, "
            +GEO_ADDRESS+" TEXT, "+UPLOAD_DATE+" TEXT, "+STEP1_IMAGE+" TEXT, "+STEP2_IMAGE+" TEXT, "
            +COST_OF_CHULLHA+" TEXT, "+ADDED_DATE+" TEXT, "+USER_UNIQUE_ID+" TEXT, "+ADDED_BY_ID+" TEXT, "+UPDATE_DATE+" TEXT)";

    private String kitchen_idValue,house_typeValue,roof_typeValue,kitchen_heightValue,
            upload_statusValue,customer_idValue,customer_nameValue,placeImageValue,
            kitchenUniqueIdValue,latitudeValue,longitudeValue,uploadDateValue,geoAddressValue,
            costOfChullhaValue,step1_imageValue,step2_imageValue,addedDateValue,userUniqueIdValue,
            addedByIdValue,updateDateValue;

    public KitchenTable() {
    }

    public KitchenTable(String kitchen_idValue, String house_typeValue, String roof_typeValue, String kitchen_heightValue, String upload_statusValue,String customer_idValue,String customer_nameValue,String placeImageValue,String geoAddressValue,String costOfChullhaValue,String kitchenUniqueIdValue,String latitudeValue,String longitudeValue,String uploadDateValue,String step1_imageValue,String step2_imageValue,String addedDateValue,String userUniqueIdValue,String addedByIdValue,String updateDateValue) {
        this.kitchen_idValue = kitchen_idValue;
        this.house_typeValue = house_typeValue;
        this.roof_typeValue = roof_typeValue;
        this.kitchen_heightValue = kitchen_heightValue;
        this.upload_statusValue=upload_statusValue;
        this.customer_idValue=customer_idValue;
        this.customer_nameValue=customer_nameValue;
        this.placeImageValue=placeImageValue;
        this.geoAddressValue=geoAddressValue;
        this.kitchenUniqueIdValue=kitchenUniqueIdValue;
        this.latitudeValue=latitudeValue;
        this.longitudeValue=longitudeValue;
        this.uploadDateValue=uploadDateValue;
        this.costOfChullhaValue=costOfChullhaValue;
        this.step1_imageValue=step1_imageValue;
        this.step2_imageValue=step2_imageValue;
        this.addedDateValue=addedDateValue;
        this.userUniqueIdValue=userUniqueIdValue;
        this.addedByIdValue=addedByIdValue;
        this.updateDateValue=updateDateValue;

    }

    protected KitchenTable(Parcel in) {
        kitchen_idValue = in.readString();
        house_typeValue = in.readString();
        roof_typeValue = in.readString();
        kitchen_heightValue = in.readString();
        upload_statusValue = in.readString();
        customer_idValue = in.readString();
        customer_nameValue = in.readString();
        placeImageValue = in.readString();
        kitchenUniqueIdValue = in.readString();
        latitudeValue = in.readString();
        longitudeValue = in.readString();
        uploadDateValue = in.readString();
        geoAddressValue = in.readString();
        costOfChullhaValue = in.readString();
        step1_imageValue=in.readString();
        step2_imageValue=in.readString();
        addedDateValue=in.readString();
        userUniqueIdValue=in.readString();
        addedByIdValue=in.readString();
        updateDateValue=in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kitchen_idValue);
        dest.writeString(house_typeValue);
        dest.writeString(roof_typeValue);
        dest.writeString(kitchen_heightValue);
        dest.writeString(upload_statusValue);
        dest.writeString(customer_idValue);
        dest.writeString(customer_nameValue);
        dest.writeString(placeImageValue);
        dest.writeString(kitchenUniqueIdValue);
        dest.writeString(latitudeValue);
        dest.writeString(longitudeValue);
        dest.writeString(uploadDateValue);
        dest.writeString(geoAddressValue);
        dest.writeString(costOfChullhaValue);
        dest.writeString(step1_imageValue);
        dest.writeString(step2_imageValue);
        dest.writeString(addedDateValue);
        dest.writeString(userUniqueIdValue);
        dest.writeString(addedByIdValue);
        dest.writeString(updateDateValue);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<KitchenTable> CREATOR = new Creator<KitchenTable>() {
        @Override
        public KitchenTable createFromParcel(Parcel in) {
            return new KitchenTable(in);
        }

        @Override
        public KitchenTable[] newArray(int size) {
            return new KitchenTable[size];
        }
    };

    public String getKitchen_idValue() {
        return kitchen_idValue;
    }

    public void setKitchen_idValue(String kitchen_idValue) {
        this.kitchen_idValue = kitchen_idValue;
    }

    public String getHouse_typeValue() {
        return house_typeValue;
    }

    public void setHouse_typeValue(String house_typeValue) {
        this.house_typeValue = house_typeValue;
    }

    public String getRoof_typeValue() {
        return roof_typeValue;
    }

    public void setRoof_typeValue(String roof_typeValue) {
        this.roof_typeValue = roof_typeValue;
    }

    public String getKitchen_heightValue() {
        return kitchen_heightValue;
    }

    public void setKitchen_heightValue(String kitchen_heightValue) {
        this.kitchen_heightValue = kitchen_heightValue;
    }

    public String getUpload_statusValue() {
        return upload_statusValue;
    }

    public void setUpload_statusValue(String upload_statusValue) {
        this.upload_statusValue = upload_statusValue;
    }

    public String getCustomer_idValue() {
        return customer_idValue;
    }

    public void setCustomer_idValue(String customer_idValue) {
        this.customer_idValue = customer_idValue;
    }

    public String getCustomer_nameValue() {
        return customer_nameValue;
    }

    public void setCustomer_nameValue(String customer_nameValue) {
        this.customer_nameValue = customer_nameValue;
    }

    public String getPlaceImageValue() {
        return placeImageValue;
    }

    public void setPlaceImageValue(String placeImageValue) {
        this.placeImageValue = placeImageValue;
    }

    public String getKitchenUniqueIdValue() {
        return kitchenUniqueIdValue;
    }

    public void setKitchenUniqueIdValue(String uniqueIdValue) {
        this.kitchenUniqueIdValue = uniqueIdValue;
    }

    public String getLatitudeValue() {
        return latitudeValue;
    }

    public void setLatitudeValue(String latitudeValue) {
        this.latitudeValue = latitudeValue;
    }

    public String getLongitudeValue() {
        return longitudeValue;
    }

    public void setLongitudeValue(String longitudeValue) {
        this.longitudeValue = longitudeValue;
    }

    public String getUploadDateValue() {
        return uploadDateValue;
    }

    public void setUploadDateValue(String uploadDateValue) {
        this.uploadDateValue = uploadDateValue;
    }

    public String getGeoAddressValue() {
        return geoAddressValue;
    }

    public void setGeoAddressValue(String geoAddressValue) {
        this.geoAddressValue = geoAddressValue;
    }

    public String getCostOfChullhaValue() {
        return costOfChullhaValue;
    }

    public void setCostOfChullhaValue(String costOfChullhaValue) {
        this.costOfChullhaValue = costOfChullhaValue;
    }

    public String getStep1_imageValue() {
        return step1_imageValue;
    }

    public void setStep1_imageValue(String step1_imageValue) {
        this.step1_imageValue = step1_imageValue;
    }

    public String getStep2_imageValue() {
        return step2_imageValue;
    }

    public void setStep2_imageValue(String step2_imageValue) {
        this.step2_imageValue = step2_imageValue;
    }

    public String getAddedDateValue() {
        return addedDateValue;
    }

    public void setAddedDateValue(String addedDateValue) {
        this.addedDateValue = addedDateValue;
    }

    public String getUserUniqueIdValue() {
        return userUniqueIdValue;
    }

    public void setUserUniqueIdValue(String userUniqueIdValue) {
        this.userUniqueIdValue = userUniqueIdValue;
    }

    public String getAddedByIdValue() {
        return addedByIdValue;
    }

    public void setAddedByIdValue(String addedByIdValue) {
        this.addedByIdValue = addedByIdValue;
    }

    public String getUpdateDateValue() {
        return updateDateValue;
    }

    public void setUpdateDateValue(String updateDateValue) {
        this.updateDateValue = updateDateValue;
    }
}

