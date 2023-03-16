package ecrf.user.search.researcher;

public interface ResearcherBatchReindexer {
	public void reindex(long researcherId, long companyId);
}
