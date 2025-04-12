import createavatar from '../assets/createavatar.png';
import createvideo from '../assets/createvideo.png';

export default function Home() {
    return (
        <div className="home-page">
            <header className="home-header">
                <h1>Welcome to AIgent</h1>
                <p>Create AI agents and videos with them</p>
            </header>
            <main>
                <section className="features">
                    <div className="feature">
                        <i className="fas fa-robot"></i>
                        <h2>Create AI Agents</h2>
                        <p>Build intelligent AI agents with ease using our intuitive interface.</p>
                        <img src={createavatar} style={{ height: '70%' }} />
                    </div>
                    <div className="feature">
                        <i className="fas fa-video"></i>
                        <h2>Create Videos</h2>
                        <p>Bring your AI agents to life by creating engaging videos with them.</p>
                        <img src={createvideo} style={{ height: '70%' }} />
                    </div>
                </section>
            </main>
        </div>
    );
}