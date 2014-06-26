<cfoutput>#now()#</cfoutput>
<cfscript>
	// Scala test!
	tester = createObject("java", "nl.rhinofly.Test");
	writeDump(tester);
	writeOutput(tester.doStuff());
</cfscript>
