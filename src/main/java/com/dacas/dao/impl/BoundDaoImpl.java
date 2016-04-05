package com.dacas.dao.impl;

import com.dacas.dao.BoundDao;
import com.dacas.data.Bound;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dave on 2016/4/5.
 */
public class BoundDaoImpl extends JdbcDaoSupport implements BoundDao{
    @Override
    public Bound getBoundById(int id) {
        String sql = "select * from bound where id = "+id;
        return getJdbcTemplate().queryForObject(sql, new RowMapper<Bound>() {
            @Override
            public Bound mapRow(ResultSet resultSet, int i) throws SQLException {
                Bound bound = new Bound();
                bound.setBoundTime(resultSet.getTime("bound_time"));
                bound.setDeviceId(resultSet.getInt("device_id"));
                bound.setId(resultSet.getInt("id"));
                bound.setPersonId(resultSet.getInt("person_id"));
                bound.setStatus(resultSet.getInt("status"));
                return bound;
            }
        });
    }
}
