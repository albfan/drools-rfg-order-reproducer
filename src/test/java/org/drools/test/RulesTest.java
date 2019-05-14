package org.drools.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesTest {

    private static KieServices KIE_SERVICES = KieServices.Factory.get();
    private static KieContainer KIE_CONTAINER = KIE_SERVICES.newKieClasspathContainer();
    
    @Test
    public void testRuleFlowGroupStartFromRequest() {
        System.out.println("Test starting RFG from RHS.");
        KieSession kieSession = KIE_CONTAINER.newKieSession();
        
        String fact = "fact";
        
        kieSession.insert(fact);
        kieSession.startProcess("test.simple-ruleflow");
        kieSession.dispose();
        
        System.out.println("\n");
    }
    
    @Test
    public void testRuleFlowGroupStartFromRhs() {
        System.out.println("Test starting RFG from RHS.");
        KieSession  kieSession = KIE_CONTAINER.newKieSession();
        
        String fact = "fact";
        String startRuleflow = "startRuleFlow";
        
        kieSession.insert(fact);
        kieSession.insert(startRuleflow);
        kieSession.fireAllRules();
        kieSession.dispose();
        
        System.out.println("\n");
    }
    
    
}
