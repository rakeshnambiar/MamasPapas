
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
    "wrapping_id",
    "design",
    "status",
    "base_price",
    "base_currency_code",
    "website_ids"
})
public class Item {

    @JsonProperty("wrapping_id")
    private Integer wrappingId;
    @JsonProperty("design")
    private Object design;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("base_price")
    private Integer basePrice;
    @JsonProperty("base_currency_code")
    private String baseCurrencyCode;
    @JsonProperty("website_ids")
    private List<Integer> websiteIds = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The wrappingId
     */
    @JsonProperty("wrapping_id")
    public Integer getWrappingId() {
        return wrappingId;
    }

    /**
     * 
     * @param wrappingId
     *     The wrapping_id
     */
    @JsonProperty("wrapping_id")
    public void setWrappingId(Integer wrappingId) {
        this.wrappingId = wrappingId;
    }

    /**
     * 
     * @return
     *     The design
     */
    @JsonProperty("design")
    public Object getDesign() {
        return design;
    }

    /**
     * 
     * @param design
     *     The design
     */
    @JsonProperty("design")
    public void setDesign(Object design) {
        this.design = design;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The basePrice
     */
    @JsonProperty("base_price")
    public Integer getBasePrice() {
        return basePrice;
    }

    /**
     * 
     * @param basePrice
     *     The base_price
     */
    @JsonProperty("base_price")
    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * 
     * @return
     *     The baseCurrencyCode
     */
    @JsonProperty("base_currency_code")
    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    /**
     * 
     * @param baseCurrencyCode
     *     The base_currency_code
     */
    @JsonProperty("base_currency_code")
    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    /**
     * 
     * @return
     *     The websiteIds
     */
    @JsonProperty("website_ids")
    public List<Integer> getWebsiteIds() {
        return websiteIds;
    }

    /**
     * 
     * @param websiteIds
     *     The website_ids
     */
    @JsonProperty("website_ids")
    public void setWebsiteIds(List<Integer> websiteIds) {
        this.websiteIds = websiteIds;
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
