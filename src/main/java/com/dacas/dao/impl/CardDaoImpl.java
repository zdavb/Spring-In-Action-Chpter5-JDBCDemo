package com.dacas.dao.impl;

import com.dacas.dao.CardDao;
import com.dacas.data.Card;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dave on 2016/4/5.
 */
public class CardDaoImpl extends JdbcDaoSupport implements CardDao {
    @Override
    public Card getCardById(int id) {
        String sql = "select * from card where id = "+id;
        return getJdbcTemplate().queryForObject(sql, new RowMapper<Card>() {
            @Override
            public Card mapRow(ResultSet resultSet, int i) throws SQLException {
                Card card = new Card();
                card.setStatus(resultSet.getInt("status"));
                card.setId(resultSet.getInt("id"));
                card.setCardSn(resultSet.getString("card_sn"));
                card.setColor(resultSet.getInt("color"));
                card.setPublicKey(resultSet.getString("public_key"));
                return card;
            }
        });
    }
}
