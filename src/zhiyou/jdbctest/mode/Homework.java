package zhiyou.jdbctest.mode;

import java.util.Iterator;

/**
 * Created by zhiyou on 15-1-24.
 */
public class Homework {
    private Integer id;
    private Integer homeworid;
    private  String answer;
    private Integer owner;
    private Integer score;

    public Integer getHomeworid() {
        return homeworid;
    }

    public void setHomeworid(Integer homeworid) {
        this.homeworid = homeworid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
