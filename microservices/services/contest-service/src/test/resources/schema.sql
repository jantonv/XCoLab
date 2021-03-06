DROP TABLE `xcolab_ProposalContestPhaseAttribute` IF EXISTS;
CREATE TABLE `xcolab_ProposalContestPhaseAttribute` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `proposalId` bigint(20) DEFAULT NULL,
  `contestPhaseId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `additionalId` bigint(20) DEFAULT NULL,
  `numericValue` bigint(20) DEFAULT NULL,
  `stringValue` longtext,
  `realValue` double DEFAULT NULL,
  PRIMARY KEY (`id_`)/*,
  KEY `IX_159C0FC9` (`contestPhaseId`),
  KEY `IX_EAA7A52A` (`contestPhaseId`,`proposalId`),
  KEY `IX_68DFE42A` (`proposalId`,`contestPhaseId`),
  KEY `IX_8F351DBF` (`proposalId`,`contestPhaseId`,`name`,`additionalId`)*/
) ENGINE=InnoDB AUTO_INCREMENT=50223 DEFAULT CHARSET=utf8;

DROP TABLE `xcolab_Proposal2Phase` IF EXISTS;
CREATE TABLE `xcolab_Proposal2Phase` (
  `proposalId` bigint(20) NOT NULL,
  `contestPhaseId` bigint(20) NOT NULL,
  `versionFrom` int(11) DEFAULT NULL,
  `versionTo` int(11) DEFAULT NULL,
  `sortWeight` int(11) DEFAULT NULL,
  `autopromoteCandidate` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`proposalId`,`contestPhaseId`)/*,
  KEY `IX_DBA8038D` (`contestPhaseId`),
  KEY `IX_D273A4B8` (`proposalId`)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE `xcolab_ContestPhase` IF EXISTS;

CREATE TABLE `xcolab_ContestPhase` (
  `ContestPhasePK` bigint(20) NOT NULL AUTO_INCREMENT,
  `ContestPK` bigint(20) DEFAULT NULL,
  `ContestPhaseType` bigint(20) DEFAULT NULL,
  `contestScheduleId` bigint(20) DEFAULT NULL,
  `fellowScreeningActive` tinyint(4) DEFAULT NULL,
  `contestPhaseAutopromote` varchar(75) DEFAULT NULL,
  `ContestPhaseDescriptionOverride` longtext,
  `phaseActiveOverride` tinyint(4) DEFAULT NULL,
  `phaseInactiveOverride` tinyint(4) DEFAULT NULL,
  `PhaseStartDate` datetime DEFAULT NULL,
  `PhaseEndDate` datetime DEFAULT NULL,
  `PhaseBufferEndDated` datetime DEFAULT NULL,
  `nextStatus` varchar(75) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ContestPhasePK`),
  -- KEY `IX_ED61C03C` (`ContestPK`),
  -- KEY `IX_2BA2B787` (`ContestPK`,`PhaseStartDate`,`PhaseEndDate`),
  -- KEY `IX_9F1D3B81` (`ContestPK`,`phaseActiveOverride`),
  -- KEY `IX_4F735B66` (`ContestPK`,`phaseInactiveOverride`),
  -- KEY `IX_1BB9EC37` (`contestPhaseAutopromote`),
  -- KEY `IX_D9B6142C` (`contestScheduleId`,`ContestPK`)
) ENGINE=InnoDB AUTO_INCREMENT=1318675 DEFAULT CHARSET=utf8;

DROP TABLE `xcolab_Contest` IF EXISTS;
CREATE TABLE `xcolab_Contest` (
  `ContestPK` bigint(20) NOT NULL,
  `contestTypeId` bigint(20) DEFAULT NULL,
  `ContestName` varchar(1024) DEFAULT NULL,
  `ContestShortName` varchar(512) DEFAULT NULL,
  `ContestUrlName` varchar(75) DEFAULT NULL,
  `ContestYear` bigint(20) DEFAULT NULL,
  `ContestDescription` longtext,
  `ContestModelDescription` longtext,
  `ContestPositionsDescription` longtext,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  `contestActive` tinyint(4) DEFAULT NULL,
  `planTemplateId` bigint(20) DEFAULT NULL,
  `contestScheduleId` bigint(20) DEFAULT NULL,
  `proposalCreationTemplateString` varchar(75) DEFAULT NULL,
  `voteTemplateString` varchar(75) DEFAULT NULL,
  `proposalVoteTemplateString` varchar(75) DEFAULT NULL,
  `proposalVoteConfirmationTemplateString` varchar(75) DEFAULT NULL,
  `voteQuestionTemplateString` varchar(75) DEFAULT NULL,
  `focusAreaId` bigint(20) DEFAULT NULL,
  `contestTier` bigint(20) DEFAULT NULL,
  `contestLogoId` bigint(20) DEFAULT NULL,
  `featured_` tinyint(4) DEFAULT NULL,
  `plansOpenByDefault` tinyint(4) DEFAULT NULL,
  `sponsorLogoId` bigint(20) DEFAULT NULL,
  `defaultProposalLogoId` BIGINT(20) NULL DEFAULT NULL,
  `sponsorText` varchar(500) DEFAULT NULL,
  `sponsorLink` varchar(75) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `flagText` varchar(256) DEFAULT NULL,
  `flagTooltip` varchar(512) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `discussionGroupId` bigint(20) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `resourcesUrl` varchar(1024) DEFAULT NULL,
  `contestPrivate` tinyint(4) DEFAULT NULL,
  `usePermissions` tinyint(4) DEFAULT NULL,
  `contestCreationStatus` varchar(75) DEFAULT NULL,
  `defaultModelId` bigint(20) DEFAULT NULL,
  `otherModels` varchar(75) DEFAULT NULL,
  `defaultModelSettings` varchar(75) DEFAULT NULL,
  `points` double DEFAULT NULL,
  `defaultParentPointType` bigint(20) DEFAULT NULL,
  `pointDistributionStrategy` varchar(75) DEFAULT NULL,
  `emailTemplateUrl` varchar(500) DEFAULT NULL,
  `show_in_tile_view` tinyint(4) DEFAULT NULL,
  `show_in_list_view` tinyint(4) DEFAULT NULL,
  `show_in_outline_view` tinyint(4) DEFAULT NULL,
  `hideRibbons` tinyint(4) DEFAULT NULL,
  `resourceArticleId` bigint(20) DEFAULT NULL,
  `isSharedContest` tinyint(4) DEFAULT '0',
  `sharedOrigin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ContestPK`) /*,
  KEY `IX_3CD643E3` (`ContestUrlName`(50),`ContestYear`),
  KEY `IX_4E7AA29D` (`ContestYear`),
  KEY `IX_CEF1EFC6` (`contestActive`),
  KEY `IX_9AB21749` (`contestActive`,`contestPrivate`),
  KEY `IX_2DC0D430` (`contestActive`,`contestPrivate`,`contestTypeId`),
  KEY `IX_4B0F5213` (`contestActive`,`contestTypeId`),
  KEY `IX_D29429DB` (`contestActive`,`featured_`),
  KEY `IX_348F875E` (`contestActive`,`featured_`,`contestPrivate`),
  KEY `IX_504C977B` (`contestActive`,`featured_`,`contestPrivate`,`contestTypeId`),
  KEY `IX_DC690B5E` (`contestActive`,`featured_`,`contestTypeId`),
  KEY `IX_491DA3A6` (`contestActive`,`flag`),
  KEY `IX_B9BA0B29` (`contestActive`,`flag`,`contestPrivate`),
  KEY `IX_1516A450` (`contestActive`,`flag`,`contestPrivate`,`contestTypeId`),
  KEY `IX_33496233` (`contestActive`,`flag`,`contestTypeId`),
  KEY `IX_168D6722` (`contestTier`),
  KEY `IX_58A2B737` (`contestTier`,`contestTypeId`),
  KEY `IX_95122F5` (`contestTypeId`),
  FULLTEXT KEY `ContestDescription_xcolab_Contest` (`ContestDescription`)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE `xcolab_ContestTranslation` IF EXISTS;
CREATE TABLE `xcolab_ContestTranslation` (
	contestId bigint(20) not null,
	lang varchar(5) not null,
	contestName varchar(255) null,
	contestShortName varchar(128) null,
	contestDescription longtext null,
	createDate timestamp not null,
	modifiedDate timestamp not null,
	authorId bigint(20) null,
	primary key (contestId, lang)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE `xcolab_Proposal` IF EXISTS;
CREATE TABLE `xcolab_Proposal` (
  `proposalId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `currentVersion` int(11) DEFAULT NULL,
  `authorId` bigint(20) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL,
  `discussionId` bigint(20) DEFAULT NULL,
  `resultsDiscussionId` bigint(20) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`proposalId`)/*,
  KEY `IX_BBC99B8B` (`updatedDate`)*/
) ENGINE=InnoDB AUTO_INCREMENT=1333836 DEFAULT CHARSET=utf8;
