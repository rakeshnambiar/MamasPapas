package com.ek.test.runCukes.reportbuilder;

import com.ek.test.framework.report.ConsolidatedReport;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by S746032 on 28/12/2015.
 */
public class ConsolidatedReportTest {
    @Test
    public void createConsolidatedReport(){
        ConsolidatedReport consolidatedReport = new ConsolidatedReport();
        try {
            consolidatedReport.copyJsonFilesFromJobs();
            consolidatedReport.getStatisticsFromJsons();
        } catch (Exception e) {
            assertTrue("Report could not be created" + e.getMessage(), false);
        }
    }
}
