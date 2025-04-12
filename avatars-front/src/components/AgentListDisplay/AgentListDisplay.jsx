import { useState, useEffect } from "react";

import Header from "./Header";
import AgentLayout from "./AgentLayout";
import VideoCreation from "./VideoCreation";
import VideoDisplay from "./VideoDisplay";

import { getVideo } from "../../http";

export default function AgentListDisplay({ activeTab, getAgents, title }) {
    const [agents, setAgents] = useState(null);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(false);
    const [tabState, setTabState] = useState('Display');
    const [selectedAgent, setSelectedAgent] = useState(null);
    const [video, setvideo] = useState(null);

    useEffect(() => {
        async function fetchAgents() {
            setIsLoading(true);
            let fetchedAgents = [];
            try {
                fetchedAgents = await getAgents();
            } catch (err) {
                setError(err.message || 'Failed to load Event Hosts.');
                setIsLoading(false);
            }
            
            setAgents(fetchedAgents);
            setIsLoading(false);
        }

        fetchAgents();
    }, [activeTab]);

    function handleAgentSelect(agent) {
        setSelectedAgent(agent);
        setTabState('VideoCreation');
    }

    async function handleVideoGeneration() {
        setTabState('VideoDisplay');
        const videoUrl = await getVideo();
        setvideo(videoUrl);
    }

    return (
        <div>
            <Header title={title} />
            {tabState === 'Display' && agents && <AgentLayout agents={agents} onAgentSelect={handleAgentSelect} />}
            {tabState === 'Display' && isLoading && <p>Loading...</p>}
            {tabState === 'Display' && error && <p>ERROR</p>}
            {tabState === 'VideoCreation' && <VideoCreation imageUrl={selectedAgent.image} onGeneration={handleVideoGeneration} />}
            {tabState === 'VideoDisplay' && <VideoDisplay video={video} />}
        </div>
    );
}