import LayoutItem from "./LayoutItem";

export default function AgentLayout({ agents, onAgentSelect }) {
    return (
        <div className="event-hosts-layout">
            {agents.map(agent => {
                return (
                    <LayoutItem item={agent} onItemClick={() => onAgentSelect(agent)} />
                );
            })}
        </div>
    );
}