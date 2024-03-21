package com.epam.rd.autocode.observer.git;

public class GitRepoObservers {
    private GitRepoObservers() {}
    public static Repository newRepository(){
        return new GitRepository();
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        return new GitWebHook(branchName, Event.Type.MERGE);
    }

    public static WebHook commitToBranchWebHook(String branchName){
        return new GitWebHook(branchName, Event.Type.COMMIT);
    }
}
