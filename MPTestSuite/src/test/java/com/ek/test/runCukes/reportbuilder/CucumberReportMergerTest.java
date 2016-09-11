package com.ek.test.runCukes.reportbuilder;

import com.ek.test.framework.report.MergeReports;
import com.ek.test.framework.tags.ReportBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by s746032 on 13/12/2015.
 */
@Category({ReportBuilder.class})
public class CucumberReportMergerTest {
    @Test
    public void mergeReports(){
        MergeReports mergeReports = new MergeReports();
        try {
            mergeReports.buildMergedReport();
        } catch (Exception e) {
            System.out.println("Report builder failed to merge the cucumber reports");
        }
    }
}
