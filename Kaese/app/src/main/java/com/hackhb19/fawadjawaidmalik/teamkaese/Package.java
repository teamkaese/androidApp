package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.os.Parcel;
import android.os.Parcelable;

public class Package implements Parcelable {
    private String id;
    private String productCategory;
    private Position position;
    private String description;
    private String storageNumber;
    private String expirationDay;
    private String admissionDate;
    private String productStage;
    private boolean isEmpty;

    public Package(String id, String productCategory, Position position, String description, String storageNumber, String expirationDay, String admissionDate, String productStage, boolean isEmpty) {
        this.id = id;
        this.productCategory = productCategory;
        this.position = position;
        this.description = description;
        this.storageNumber = storageNumber;
        this.expirationDay = expirationDay;
        this.admissionDate = admissionDate;
        this.productStage = productStage;
        this.isEmpty = isEmpty;
    }

    public Package(String id, String productCategory, String description, String expirationDay) {
        this.id = id;
        this.productCategory = productCategory;
        this.description = description;
        this.expirationDay = expirationDay;
    }

    protected Package(Parcel in) {
        id = in.readString();
        productCategory = in.readString();
        description = in.readString();
        storageNumber = in.readString();
        expirationDay = in.readString();
        admissionDate = in.readString();
        productStage = in.readString();
        isEmpty = in.readByte() != 0;
    }

    public static final Creator<Package> CREATOR = new Creator<Package>() {
        @Override
        public Package createFromParcel(Parcel in) {
            return new Package(in);
        }

        @Override
        public Package[] newArray(int size) {
            return new Package[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber;
    }

    public String getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(String expirationDay) {
        this.expirationDay = expirationDay;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getProductStage() {
        return productStage;
    }

    public void setProductStage(String productStage) {
        this.productStage = productStage;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(productCategory);
        parcel.writeString(description);
        parcel.writeString(storageNumber);
        parcel.writeString(expirationDay);
        parcel.writeString(admissionDate);
        parcel.writeString(productStage);
        parcel.writeByte((byte) (isEmpty ? 1 : 0));
    }
}
