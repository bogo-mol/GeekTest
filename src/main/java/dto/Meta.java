package dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prevPage",
    "nextPage",
    "count"
})
@Generated("jsonschema2pojo")
public class Meta {

    @JsonProperty("prevPage")
    private Integer prevPage;
    @JsonProperty("nextPage")
    private Integer nextPage;
    @JsonProperty("count")
    private Integer count;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("prevPage")
    public Integer getPrevPage() {
        return prevPage;
    }

    @JsonProperty("prevPage")
    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    @JsonProperty("nextPage")
    public Integer getNextPage() {
        return nextPage;
    }

    @JsonProperty("nextPage")
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
