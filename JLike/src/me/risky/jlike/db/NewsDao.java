package me.risky.jlike.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import me.risky.jlike.db.News;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table NEWS.
*/
public class NewsDao extends AbstractDao<News, Long> {

    public static final String TABLENAME = "NEWS";

    /**
     * Properties of entity News.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property DetailUrl = new Property(3, String.class, "detailUrl", false, "DETAIL_URL");
        public final static Property ImageSrc = new Property(4, String.class, "imageSrc", false, "IMAGE_SRC");
        public final static Property ScanNum = new Property(5, String.class, "scanNum", false, "SCAN_NUM");
        public final static Property DateTime = new Property(6, String.class, "dateTime", false, "DATE_TIME");
        public final static Property Type = new Property(7, Integer.class, "type", false, "TYPE");
    };


    public NewsDao(DaoConfig config) {
        super(config);
    }
    
    public NewsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'NEWS' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TITLE' TEXT," + // 1: title
                "'CONTENT' TEXT," + // 2: content
                "'DETAIL_URL' TEXT," + // 3: detailUrl
                "'IMAGE_SRC' TEXT," + // 4: imageSrc
                "'SCAN_NUM' TEXT," + // 5: scanNum
                "'DATE_TIME' TEXT," + // 6: dateTime
                "'TYPE' INTEGER);"); // 7: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'NEWS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, News entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String detailUrl = entity.getDetailUrl();
        if (detailUrl != null) {
            stmt.bindString(4, detailUrl);
        }
 
        String imageSrc = entity.getImageSrc();
        if (imageSrc != null) {
            stmt.bindString(5, imageSrc);
        }
 
        String scanNum = entity.getScanNum();
        if (scanNum != null) {
            stmt.bindString(6, scanNum);
        }
 
        String dateTime = entity.getDateTime();
        if (dateTime != null) {
            stmt.bindString(7, dateTime);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(8, type);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public News readEntity(Cursor cursor, int offset) {
        News entity = new News( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // detailUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // imageSrc
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // scanNum
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // dateTime
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7) // type
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, News entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDetailUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImageSrc(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setScanNum(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDateTime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setType(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(News entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(News entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }

    
    
    // add by chenupt
    public void deleteNewsByType(int type){
    	getDatabase().execSQL("delete from " + TABLENAME + " where type = " + type);
    }
    
}
