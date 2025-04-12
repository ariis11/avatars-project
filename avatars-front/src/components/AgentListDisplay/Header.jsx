

export default function Header({ title }) {
    return (
        <nav className="progress-header">
            <span>{title}s</span>
            <button className="new-agent-button">
                + New {title}
            </button>
        </nav>
    );
}