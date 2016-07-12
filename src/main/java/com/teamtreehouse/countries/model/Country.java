package com.teamtreehouse.countries.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Country {
    private int mId;
    private String mName;
    private String mSlugFromName;
    private Long mPopulation;
    private String mCapital;
    private List<String> mLanguages;
    private String mFlagFileName;

    public int getId() {
        return mId;
    }
    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }
    public String getSlugFromName() {
        return mSlugFromName;
    }
    public void setName(String name) {
        mName = name;
    }

    public Long getPopulation() {
        return mPopulation;
    }
    // used to print population in html in nice format
    public String getPopulationHumanReadableFormat() {
        return NumberFormat.getNumberInstance(Locale.US).format(mPopulation);
    }

    public void setPopulation(Long population) {
        mPopulation = population;
    }

    public String getCapital() {
        return mCapital;
    }

    public void setCapital(String capital) {
        mCapital = capital;
    }

    public List<String> getLanguages() {
        return mLanguages;
    }

    public void setLanguages(List<String> languages) {
        mLanguages = languages;
    }

    public String getFlagFileName() {
        return mFlagFileName;
    }

    public void setFlagFileName(String flagFileName) {
        mFlagFileName = flagFileName;
    }

    public Country(int id,
                   String name,
                   Long population,
                   String capital,
                   List<String> languages,
                   String flagFileName) {
        mId = id;
        mName = name;
        mPopulation = population;
        mCapital = capital;
        mLanguages = languages;
        mFlagFileName = flagFileName;
    }

    public Country(CountryBuilder builder) {
        mId = builder.mId;
        mName = builder.mName;
        mPopulation = builder.mPopulation;
        mCapital = builder.mCapital;
        mLanguages = builder.mLanguages;
        mFlagFileName = builder.mFlagFileName;
        try {
            Slugify slugify = new Slugify();
            mSlugFromName = slugify.slugify(mName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // builder class
    public static class CountryBuilder {
        private int mId;
        private String mName;
        private Long mPopulation;
        private String mCapital;
        private List<String> mLanguages;
        private String mFlagFileName;


        public CountryBuilder(int id) {
            mId = id;
        }
        public CountryBuilder withName(String name) {
            mName = name;
            return this;
        }
        public CountryBuilder withPopulation(Long population) {
            mPopulation = population;
            return this;
        }
        public CountryBuilder withCapital(String capital) {
            mCapital = capital;
            return this;
        }
        public CountryBuilder withLanguages(List<String> languages) {
            mLanguages = languages;
            return this;
        }
        public CountryBuilder withFlagFileName(String flagFileName) {
            mFlagFileName = flagFileName;
            return this;
        }
        public Country build() {
            return new Country(this);
        }
    }
}
