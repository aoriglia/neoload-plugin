/*
 * Copyright (c) 2013, Neotys
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Neotys nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL NEOTYS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.jenkinsci.plugins.neoload_integration;

import hudson.tasks.BuildStepMonitor;
import junit.framework.TestCase;

import org.jenkinsci.plugins.neoload_integration.supporting.MockObjects;
import org.junit.Before;
import org.junit.Test;

public class NeoPostBuildActionTest extends TestCase {

	/** Mock project for testing. */
	private MockObjects mo = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		mo = new MockObjects();
	}

	@Test
	public void testNeoPostBuildAction() {
		final NeoPostBuildAction neoPostBuildAction = new NeoPostBuildAction(false, false);
		assertNotNull(neoPostBuildAction);
	}

	@Test
	public void testNeoPostBuildActionDescriptorImpl() {
		final NeoPostBuildAction.DescriptorImpl di = new NeoPostBuildAction.DescriptorImpl();
		di.getDisplayName();
		di.isApplicable(null);
	}

	@Test
	public void testPerform() {
		final NeoPostBuildAction npba = new NeoPostBuildAction(false, false);
		npba.perform(mo.getAbstractBuild(), null, null);
	}

	@Test
	public void testGetRequiredMonitorService() {
		final NeoPostBuildAction npba = new NeoPostBuildAction(false, false);
		assertTrue(npba.getRequiredMonitorService() == BuildStepMonitor.NONE);
	}

	@Test
	public void testIsShowTrendAverageResponse() {
		NeoPostBuildAction npba = new NeoPostBuildAction(false, false);
		assertFalse(npba.isShowTrendAverageResponse());
		npba = new NeoPostBuildAction(true, true);
		assertTrue(npba.isShowTrendAverageResponse());
	}

	@Test
	public void testIsShowTrendErrorRate() {
		NeoPostBuildAction npba = new NeoPostBuildAction(false, false);
		assertFalse(npba.isShowTrendErrorRate());
		npba = new NeoPostBuildAction(true, true);
		assertTrue(npba.isShowTrendErrorRate());
	}

}
