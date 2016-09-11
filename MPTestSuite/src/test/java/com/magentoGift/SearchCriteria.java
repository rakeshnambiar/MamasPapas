
package com.magentoGift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "filter_groups"
})
public class SearchCriteria {

    @JsonProperty("filter_groups")
    private List<FilterGroup> filterGroups = new ArrayList<FilterGroup>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The filterGroups
     */
    @JsonProperty("filter_groups")
    public List<FilterGroup> getFilterGroups() {
        return filterGroups;
    }

    /**
     * 
     * @param filterGroups
     *     The filter_groups
     */
    @JsonProperty("filter_groups")
    public void setFilterGroups(List<FilterGroup> filterGroups) {
        this.filterGroups = filterGroups;
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
