package org.sunyulstercs.supportsmeapp;

import android.os.Parcel;
import android.os.Parcelable;


public class InfoItem implements Parcelable
{
    private String title;
    private String desc;
    private String link;
    private String phoneNumber;

    InfoItem(String[] items)
    {
        this.title = items[0];

        if (items.length >= 2)
        {
            if (!items[1].isEmpty())
            {
                this.desc = items[1];


                if (items.length >= 3) {
                    if (!items[2].isEmpty()) {
                        this.link = items[2];
                    }

                    if (items.length >= 4) {
                        if (!items[3].isEmpty()) {
                            this.phoneNumber = items[3];
                        }
                    }
                }
            }
        }

    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getFormattedPhoneNumber()
    {
        StringBuilder sb = new StringBuilder();
        if (this.hasPhoneNumber())
        {
            sb.append("tel:");
            sb.append(this.phoneNumber);
            sb.deleteCharAt(sb.indexOf("–"));
        }
        return sb.toString();
    }

    boolean hasLink()
    {
        return this.link != null;
    }

    boolean hasPhoneNumber()
    {
        return this.phoneNumber != null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeString(this.link);
        dest.writeString(this.phoneNumber);
    }

    private InfoItem(Parcel in) {
        this.title = in.readString();
        this.desc = in.readString();
        this.link = in.readString();
        this.phoneNumber = in.readString();
    }

    public static final Parcelable.Creator<InfoItem> CREATOR = new Parcelable.Creator<InfoItem>() {
        @Override
        public InfoItem createFromParcel(Parcel source) {
            return new InfoItem(source);
        }

        @Override
        public InfoItem[] newArray(int size) {
            return new InfoItem[size];
        }
    };

    boolean hasDesc()
    {
        return this.desc != null;
    }
}
