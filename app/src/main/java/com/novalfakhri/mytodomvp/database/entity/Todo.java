package com.novalfakhri.mytodomvp.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Toshiba on 9/29/2017.
 */

@Entity(nameInDb = "Todo")
public class Todo {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "Title")
    private String title;
    @Property(nameInDb = "Checked")
    private boolean checked;

    @Generated(hash = 478157636)
    public Todo(Long id, String title, boolean checked) {
        this.id = id;
        this.title = title;
        this.checked = checked;
    }
    @Generated(hash = 1698043777)
    public Todo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean getChecked() {
        return this.checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
