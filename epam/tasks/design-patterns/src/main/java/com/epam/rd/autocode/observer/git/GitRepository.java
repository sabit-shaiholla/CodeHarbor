package com.epam.rd.autocode.observer.git;

import java.util.*;
import java.util.stream.Collectors;

public class GitRepository implements Repository{
    private List<Commit> commits = new ArrayList<>();
    private final List<WebHook> webHooks = new ArrayList<>();

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(branch, author, changes);
        if (!webHooks.isEmpty()) {
            commits.add(commit);
            webHooks.stream()
                    .filter(webHook -> webHook.type().equals(Event.Type.COMMIT) && webHook.branch().equals(branch))
                    .forEach(webHook -> webHook.onEvent(new Event(Event.Type.COMMIT, branch, Collections.singletonList(commit))));
        }
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> sourceBranchCommits = getCommits(sourceBranch);

        if (hasMergeWebHook(webHooks)) {
            notifyHooksAboutMerge(targetBranch, sourceBranchCommits);
        }
    }

    private List<Commit> getCommits(String branch) {
        return commits.stream()
                .filter(commit -> commit.branch().equals(branch))
                .collect(Collectors.toList());
    }

    private void notifyHooksAboutMerge(String targetBranch, List<Commit> targetBranchCommits) {
        webHooks.stream()
                .filter(webHook -> webHook.type() == Event.Type.MERGE && webHook.branch().equals(targetBranch))
                .forEach(webHook -> webHook.onEvent(new Event(Event.Type.MERGE, targetBranch, targetBranchCommits)));
    }

    private boolean hasMergeWebHook(List<WebHook> webHooks) {
        return webHooks.stream()
                .findFirst()
                .filter(webHook -> webHook.type().equals(Event.Type.MERGE))
                .isPresent();
    }
}
