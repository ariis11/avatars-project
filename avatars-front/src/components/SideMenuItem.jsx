export default function SideMenuItem({ setActiveTab, title, image, activeTab }) {
    return (
        <button className={`tab ${activeTab === title ? 'active' : ''}`} onClick={() => setActiveTab(title)}>
            <img src={image} />
            <span>{title}</span>
        </button>
    );
}